# Networking Basics
**Module:** Networking Basics `COMP H1015`  
**Lectorer:** Conn Cremin  
**Duration:** Semester 1 (Year 1)  
**Date:** September - December 2023  
**Credits:** 5 ECTS

> This module provides an introduction to the fundamental concepts of computer networks. The course covers a range of topics, including network devices, protocols, and network configuration. The primary goal is to develop an understanding of computer networks and their applications in real-world scenarios. The course also includes practical exercises to reinforce the theoretical concepts. IP addressing, subnetting, and network troubleshooting are some of the key topics covered in this module.

## Grades Breakdown
| **Assessment Type** | **Weighting** |
|---------------------|---------------|
| Weekly labs (weeks 1-11) | idk |
| CA 1 — MSQ test (week 9) | idk |
| Probaly something else... | idk |

## Table of Contents
- [Weeks](#weeks)
    - [Week 1](#week-1-lab-1-network-introduction): Network Introduction
    - [Week 2-6](#week-2-6-idk-but-for-some-reason-i-dont-have-them): Idk but for some reason I don't have them
    - [Week 7](#week-7-review-week): Review Week
    - [Week 8](#week-8-lab-7-configure-ipv6-addressing): Configure IPv6 Addressing
    - [Week 9](#week-9-lab-8-troubleshooting-default-gateway-issues): Troubleshooting Default Gateway Issues
    - [Week 10](#week-10-lab-9-subnetting-scenario-1): Subnetting Scenario
    - [Week 11](#week-11-lab-10-designing-and-implementing-a-vlsm-addressing-scheme): Designing and Implementing a VLSM Addressing Scheme

## Weeks

### [Week 1 (Lab 1)](./week01/lab/): Network Introduction
[Task](./week01/lab/networking_basics_week01_lab_network_introduction.pdf)

This laboratory exercise introduces students to the basic Windows command-line networking tools to check connectivity.

![Week 1, Lab 1 Screenshot](./_screenshots/week01/screenshot.png)

#### Objectives
At the end of this laboratory exercise, students should be able to:
- Use the basic Windows command-line networking tools to check connectivity.

#### Command-Line Networking Tools
There are a number of Command-Line (or Windows Console) programs included with the Windows operating systems. The following programs used in this module's laboratory exercises are located on the C drive.

| Program | Description |
|---------|-------------|
| IPCONFIG.EXE | Used to view current network configuration. |
| NET.EXE | Used to view Microsoft network shared resources. |
| PING.EXE | Basic connectivity test between two systems running TCP/IP. |
| ARP.EXE | Uses ARP (Address Resolution Protocol) to provide dynamic mapping from an IP address to the corresponding hardware (MAC) address. |
| TRACERT.EXE | Traces the route that IP datagrams follow from one host to another. |
| NETSTAT.EXE | Displays protocol statistics and current TCP/IP network connections. |

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

### Week 2-6: Idk but for some reason I don't have them
`null`

### Week 7: Review Week
> No lectures and labs this week.

### [Week 8 (Lab 7)](./week08/lab/): Configure IPv6 Addressing
[Task](./week08/lab/networking_basics_week08_lab_configure_ipv6_addressing.pdf) | [Packet Tracer Solution (.pka)](./week08/lab/solution/networking_basics_week08_lab_configure_ipv6_addressing.pka)

This laboratory exercise introduces the configuration of IPv6 addressing on a router, servers, and clients.

![Week 8, Lab 7 Screenshot](./_screenshots/week08/screenshot.png)

#### Objectives
1. Configure IPv6 Addressing on the Router
2. Configure IPv6 Addressing on Servers
3. Configure IPv6 Addressing on Clients
4. Test and Verify Network Connectivity

### [Week 9 (Lab 8)](./week09/lab/): Troubleshooting Default Gateway Issues
[Task](./week09/lab/networking_basics_week09_lab_troubleshooting_default_gateway_issues.pdf) | [Packet Tracer Solution (.pka)](./week09/lab/solution/networking_basics_week09_lab_troubleshooting_default_gateway_issues.pka)

This laboratory exercise introduces the troubleshooting of default gateway issues on a router, servers, and clients.

![Week 9, Lab 8 Screenshot](./_screenshots/week09/screenshot.png)

#### Objectives
1. Verify Network Documentation and Isolate Problems
2. Implement, Verify, and Document Solutions

### [Week 10 (Lab 9)](./week10/lab/): Subnetting Scenario 1
[Task](./week10/lab/networking_basics_week10_lab_subnetting_scenario_1.pdf) | [Packet Tracer Solution (.pka)](./week10/lab/solution/networking_basics_week10_lab_subnetting_scenario_1.pka)

This laboratory exercise introduces the subnetting scenario on a router, servers, and clients.

![Week 10, Lab 9 Screenshot](./_screenshots/week10/screenshot.png)

#### Objectives
1. Design an IP Addressing Scheme
2. Assign IP Addresses to Network Devices and Verify Connectivity

### [Week 11 (Lab 10)](./week11/lab/): Designing and Implementing a VLSM Addressing Scheme
[Task](./week11/lab/networking_basics_week11_lab_designing_and_implementing_a_vlsm_addressing_scheme.pdf) | [Packet Tracer Solution (.pka)](./week11/lab/solution/networking_basics_week11_lab_designing_and_implementing_a_vlsm_addressing_scheme.pka)

This laboratory exercise introduces the design and implementation of a VLSM addressing scheme on a router, servers, and clients.

![Week 11, Lab 10 Screenshot](./_screenshots/week11/screenshot.png)

#### Objectives
1. Examine the Network Requirements
2. Design the VLSM Addressing Scheme
3. Assign IP Addresses to Devices and Verify Connectivity
