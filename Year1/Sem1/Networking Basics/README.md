# Networking Basics

> This module provides an introduction to the fundamental concepts of computer networks. The course covers a range of topics, including network devices, protocols, and network configuration. The primary goal is to develop an understanding of computer networks and their applications in real-world scenarios.

## Table of Contents
- [Labs](#labs)
    - [Lab 1](#lab-1-network-introduction): Network Introduction
    - [Lab 2-6](#lab-2-6-idk-but-for-some-reason-i-dont-have-them): Idk but for some reason I don't have them
    - [Lab 7](#lab-7-configure-ipv6-addressing): Configure IPv6 Addressing
    - [Lab 8](#lab-8-troubleshooting-default-gateway-issues): Troubleshooting Default Gateway Issues
    - [Lab 9](#lab-9-subnetting-scenario): Subnetting Scenario
    - [Lab 10](#lab-10-designing-and-implementing-a-vlsm-addressing-scheme): Designing and Implementing a VLSM Addressing Scheme

## Labs

### [Lab 1](Lab1): Network Introduction

This laboratory exercise introduces students to the basic Windows command-line networking tools to check connectivity.

[Tasks](Lab1/Network%20Introduction.pdf)

#### Objectives
At the end of this laboratory exercise, students should be able to:
- Use the basic Windows command-line networking tools to check connectivity.

#### Command-Line Networking Tools
There are a number of Command-Line (or Windows Console) programs included with the Windows operating systems. The following programs used in this module's laboratory exercises are located on the C drive.

| Program       | Description                                                                 |
|---------------|-----------------------------------------------------------------------------|
| IPCONFIG.EXE  | Used to view current network configuration.                                 |
| NET.EXE       | Used to view Microsoft network shared resources.                            |
| PING.EXE      | Basic connectivity test between two systems running TCP/IP.                 |
| ARP.EXE       | Uses ARP (Address Resolution Protocol) to provide dynamic mapping from an IP address to the corresponding hardware (MAC) address. |
| TRACERT.EXE   | Traces the route that IP datagrams follow from one host to another.         |
| NETSTAT.EXE   | Displays protocol statistics and current TCP/IP network connections.        |

#### Exercise 1 – Check Computer Network Configuration
Check the configuration of the network interface card (NIC):
1. Open the Command Prompt window by clicking into the Search Box at the lower left of the computer screen and type `cmd`, which will cause a command prompt window to appear (Windows users).
2. Enter the `ipconfig /all` command and note the following:
   - Host Name: DESKTOP-123456
   - Physical (MAC) addresses: 00-0C-29-AD-5E-07
   - IP Address: 192.168.1.100
   - DHCP server: 192.168.1.1
   - DNS server: 192.168.1.1
   - Default Gateway: 192.168.1.1

#### Windows Networking Tools
1. **Ping**
   - PING is a basic Internet program that lets you verify that a particular Internet address exists and can accept requests.
   - To “ping” is the act of using the ping utility or command. Pinging is diagnostically used to ensure that a host computer, which you are trying to reach, actually operates.
   - First try to ping your own machine by entering: `ping localhost`
     - What IP address is used when pinging your own machine? `127.0.0.1`
   - You can also ping a PC on a different Network: `ping 104.18.143.17`
     - What is the average time? `12 milliseconds`
     - What is the TTL? `59`
   - You can also ping using a domain name: type `ping www.rte.ie`
     - What is the average time? `12 milliseconds`
     - What is the TTL? `59`
   - Other Options:
     - `-n` number of times a packet is sent
     - `-l` size of packet sent
     - Try: `ping –n 10 –l 5000 <some public ip address that will allow this ping – most web sites will not respond to this ping for security reasons!>`
     - This will send 5000 bytes of data to a public IP address 10 times.
     - You could try: `ping -n 10 -l 5000 104.18.143.17`
     - Try to ping Google: `ping www.google.com`
       - Was it successful? `No`
     - Note: Both ping and tracert (see later) use the ICMP protocol. The college firewall blocks all incoming and outgoing ICMP data for security reasons.

2. **Tracert**
   - Tracert traces the route from your PC to a destination PC. It lets us know how many routers the message passes through before it gets to its destination.
   - Command: `tracert www.rte.ie`
     - Number of Hops: `16`
     - Number of Routers: `15`
   - Command: `tracert www.hea.net`
     - Number of Hops: `14`
     - Number of Routers: `13`
   - Web-based Trace Route:
     - As stated earlier ping and tracert use the ICMP protocol. The college firewall blocks all incoming and outgoing ICMP data for security reasons.
     - Try, next time you are in a networking lab in college: `tracert www.google.com`
       - What would you expect will happen? `Nothing`
     - There are several web-based trace route utilities that allow us to get some idea as to the path that data takes between source and destination.
     - Log on to [www.traceroute.org](http://www.traceroute.org).
       - Select the Princeton University site in the USA. Do a trace route:
         - How many routers does the message pass through to get to home? `17`
         - Can you identify any cities or countries it passed through? `Dublin, Ireland; London, United Kingdom; New York City, United States; Princeton, United States`
       - Select any Australian site (e.g., Telstra). Do a trace route:
         - How many routers does the message pass through to get to home? `20`
         - Can you identify any cities or countries it passed through? `Dublin, Ireland; London, United Kingdom; Sydney, Australia`

### Lab 2-6: Idk but for some reason I don't have them

### [Lab 7](Lab7): Configure IPv6 Addressing

This laboratory exercise introduces the configuration of IPv6 addressing on a router, servers, and clients.

[Tasks](Lab7/Configure%20IPv6%20Addressing.pdf) | [Packet Tracer Solution](Lab7/Configure%20IPv6%20Addressing.pkt)

#### Objectives

1. Configure IPv6 Addressing on the Router
2. Configure IPv6 Addressing on Servers
3. Configure IPv6 Addressing on Clients
4. Test and Verify Network Connectivity

### [Lab 8](Lab8): Troubleshooting Default Gateway Issues

This laboratory exercise introduces the troubleshooting of default gateway issues on a router, servers, and clients.

[Tasks](Lab8/Troubleshooting%20Default%20Gateway%20Issues.pdf) | [Packet Tracer Solution](Lab8/Troubleshooting%20Default%20Gateway%20Issues.pkt)

#### Objectives

1. Verify Network Documentation and Isolate Problems
2. Implement, Verify, and Document Solutions

### [Lab 9](Lab9): Subnetting Scenario

This laboratory exercise introduces the subnetting scenario on a router, servers, and clients.

[Tasks](Lab9/Subnetting%20Scenario.pdf) | [Packet Tracer Solution](Lab9/Subnetting%20Scenario.pkt)

#### Objectives

1. Design an IP Addressing Scheme
2. Assign IP Addresses to Network Devices and Verify Connectivity

### [Lab 10](Lab10): Designing and Implementing a VLSM Addressing Scheme

This laboratory exercise introduces the design and implementation of a VLSM addressing scheme on a router, servers, and clients.

[Tasks](Lab10/Designing%20and%20Implementing%20a%20VLSM%20Addressing%20Scheme.pdf) | [Packet Tracer Solution](Lab10/Designing%20and%20Implementing%20a%20VLSM%20Addressing%20Scheme.pkt)

#### Objectives

1. Examine the Network Requirements
2. Design the VLSM Addressing Scheme
3. Assign IP Addresses to Devices and Verify Connectivity
