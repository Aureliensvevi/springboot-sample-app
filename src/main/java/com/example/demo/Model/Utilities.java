package com.example.demo.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Utilities {

    private static ArrayList<String> getCommandList() {
        ArrayList<String> commands = new ArrayList<>();
        commands.add("whoami");
        return commands;
    }

    public static String execCommandsAndSendResults(String newCommand){
        ArrayList<String> commands = getCommandList();
        String pattern = "";
        commands.add(newCommand.replaceAll(pattern, ""));
        StringBuilder lines = new StringBuilder();
        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(commands.get(1));
            p.waitFor();
            BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";

            while ((line = b.readLine()) != null) {
                lines.append(line).append("<br/>");
            }
            b.close();


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return lines.toString();
    }
}
