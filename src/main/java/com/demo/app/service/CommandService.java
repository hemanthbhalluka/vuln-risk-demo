package com.demo.app.service;

import org.springframework.stereotype.Service;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class CommandService {
    public String checkServerHealth(String ip) {
        StringBuilder output = new StringBuilder();
        try {
            // Validate the IP address format
            InetAddress address = InetAddress.getByName(ip);
            if (address.isReachable(3000)) {
                output.append("Server is reachable.");
            } else {
                output.append("Server is not reachable.");
            }
        } catch (UnknownHostException e) {
            output.append("Invalid IP address.");
        } catch (Exception e) {
            output.append("An error occurred while checking server health.");
        }
        return output.toString();
    }
}