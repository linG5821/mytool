package com.ling5821.mytool;

import com.ling5821.mytool.docker.DockerBuildScript;

import java.util.Scanner;

/**
 * @author lsj
 * @date 2021/4/9 10:13
 */
public class MyToolStarter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("dbs:\t generate docker build script");
            System.out.println("exit:\t exit this tool");
            String option = scanner.nextLine();
            switch (option) {
                case "dbs":
                    System.out.println("Please enter imageName");
                    String image = scanner.nextLine();
                    System.out.println("Please enter endpoint");
                    String endpoint = scanner.nextLine();
                    System.out.println("Please enter username");
                    String username = scanner.nextLine();
                    System.out.println("Please enter password");
                    String password = scanner.nextLine();
                    DockerBuildScript.generateJavaBuildScript(image, endpoint, username, password);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Please enter the correct option");
                    break;
            }
        }
    }
}
