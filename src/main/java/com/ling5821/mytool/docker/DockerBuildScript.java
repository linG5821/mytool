package com.ling5821.mytool.docker;

/**
 * @author lsj
 * @date 2021/4/9 10:14
 */
public class DockerBuildScript {

    public static void generateJavaBuildScript(String image, String endpoint, String username, String password) {
        System.out.println("===shell start===");
        System.out.println("mvn clean package");
        System.out.println(String.format("docker build -t %s:$1 .", image));
        System.out.println(String.format("docker login %s --username %s --password %s", endpoint, username, password));
        System.out.println(String.format("docker tag $(docker images %s:$1 -q) %s:latest", image, image));
        System.out.println(String.format("docker push %s:$1", image));
        System.out.println(String.format("docker push %s:latest", image));
        System.out.println("===shell end===");
        System.out.println();
        System.out.println("===bat start===");
        System.out.println("@ECHO OFF");
        System.out.println("SET version=%1");
        System.out.println("CALL mvn clean package");
        System.out.println(String.format("CALL docker build -t %s:%%version%% .", image));
        System.out.println(String.format("CALL docker login %s --username %s --password %s", endpoint, username, password));
        System.out.println(String.format("FOR /f %%%%i in ('docker images %s:%%version%% -q') do (SET imageId=%%%%i)", image));
        System.out.println(String.format("CALL docker tag %%imageId%% %s:latest", image));
        System.out.println(String.format("CALL docker push %s:%%version%%", image));
        System.out.println(String.format("CALL docker push %s:latest", image));
        System.out.println("===bat end===");
    }

}
