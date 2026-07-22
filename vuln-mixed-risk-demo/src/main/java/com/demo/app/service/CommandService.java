package com.demo.app.service;
// VULN: CWE-78 (HIGH) - OS Command Injection via unsanitized 'ip' parameter
import org.springframework.stereotype.Service;
import java.io.InputStreamReader;
import java.io.BufferedReader;
@Service
public class CommandService {
    public String checkServerHealth(String ip) {
        StringBuilder output = new StringBuilder();
        try {
            Process p = Runtime.getRuntime().exec("ping -c 3 " + ip);
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) { output.append(line); }
        } catch (Exception e) {}
        return output.toString();
    }
}