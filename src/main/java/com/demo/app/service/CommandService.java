package com.demo.app.service;

import org.springframework.stereotype.Service;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class CommandService {
    public String checkServerHealth(String ip) {
        StringBuilder output = new StringBuilder();
        try {
            InetAddress address = InetAddress.getByName(ip);
            boolean reachable = address.isReachable(3000);
            output.append("Ping result for ").append(ip).append(": ").append(reachable ? "Reachable" : "Not reachable");
        } catch (UnknownHostException e) {
            output.append("Invalid IP address: ").append(ip);
        } catch (Exception e) {
            output.append("Error checking server health.");
        }
        return output.toString();
    }
}