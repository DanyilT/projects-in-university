# Routers and Routing Basics
**Module:** Routers and Routing Basics `COMP H1021`  
**Lectorer:** Conn Cremin  
**Duration:** Semester 2 (Year 1)  
**Date:** January - May 2024  
**Credits:** 5 ECTS

> This module introduces the architecture, components, and operations of routers and switches in a small network. It covers how to configure a router and a switch for basic functionality. The primary goal is to develop an understanding of networking concepts and partical skills to configure a small network, including the ability to perform basic router and switch configurations. Had some hardware (real routers and switches) labs and Packet Tracer (virtual) labs.

## Grades Breakdown
| **Assessment Type** | **Weighting** |
|---------------------|---------------|
| Weekly labs | idk |
| CA 1 (practical exam) | idk |
| CA 2 (MCQ test) | idk |
| Cisco Academy Exams | idk |

> ![WARNING]
> **Cisco Academy**  
> This module also had cisco academy component, and there was some exams there.

## Table of Contents
- [Weeks](#weeks)
    - [Week 1 (Lab 1)](#week-1-lab-1-basic-switch-configuration): Basic Switch Configuration
    - [Week 2 (Lab 2)](#week-2-lab-2-configure-ssh): Configure SSH
    - [Week 3 (Lab 3)](#week-3-lab-3-configure-router-interfaces): Configure Router Interfaces
    - [Week 4 (Lab 4)](#week-4-lab-4-implement-vlans-and-trunking): Implement VLANs and Trunking
    - [Week 5 (Lab 5)](#week-5-lab-5-configure-router-on-a-stick-inter-vlan-routing): Configure Router on a Stick Inter VLAN Routing
    - [Week 6 (Lab 6)](#week-6-lab-6-configure-dhcpv4): Configure DHCPv4
    - [Week 7 (Lab 7)](#week-7-lab-7-configuring-ipv4-static-and-default-routes): Configuring IPv4 Static and Default Routes
    - [Week 8 (Lab 8)](#week-8-lab-8-configuring-ipv6-static-and-default-routes): Configuring IPv6 Static and Default Routes
    - [Week 10 (CA 1)](#week-10-ca-1-practical-packet-tracer-exam): Practical Packet Tracer exam
    - [Week 12 (CA 2)](#week-12-ca-2-mcq-test): MCQ Test

## Labs

### [Week 1 (Lab 1)](./week01/lab/): Basic Switch Configuration
[Task](./week01/lab/routers_and_routing_basics_week01_lab_basic_switch_configuration.pdf) | [Packet Tracer Solution (.pkt)](./week01/lab/solution/routers_and_routing_basics_week01_lab_basic_switch_configuration.pkt)

This laboratory exercise introduces students to the basic switch configuration.

![Week 1, Lab 1 screenshot](./_screenshots/week01/screenshot.png)

#### Objectives
1. Cable the Network and Verify the Default Switch Configuration
2. Configure Basic Network Device Settings
    - Configure basic switch settings.
    - Configure the PC IP address.
3. Verify and Test Network Connectivity
    - Display device configuration.
    - Test end-to-end connectivity with ping.
    - Test remote management capabilities with Telnet.
4. Manage the MAC Address Table
    - Record the MAC address of the host.
    - Determine the MAC addresses that the switch has learned.
    - List the show mac address-table command options.
    - Set up a static MAC address

### [Week 2 (Lab 2)](./week02/lab/): Configure SSH
[Task](./week02/lab/routers_and_routing_basics_week02_lab_configure_ssh.pdf) | [Packet Tracer Solution (.pka)](./week02/lab/solution/routers_and_routing_basics_week02_lab_configure_ssh.pka)

This laboratory exercise introduces students to the Secure Shell (SSH) protocol.

![Week 2, Lab 2 screenshot](./_screenshots/week02/screenshot.png)

#### Objectives
1. Secure Passwords
2. Encrypt Communications
3. Verify SSH Implementation

### [Week 3 (Lab 3)](./week03/lab/): Configure Router Interfaces
[Task](./week03/lab/routers_and_routing_basics_week03_lab_configure_router_interfaces.pdf) | [Packet Tracer Solution (.pka)](./week03/lab/solution/routers_and_routing_basics_week03_lab_configure_router_interfaces.pka)

This laboratory exercise introduces students to the configuration of router interfaces.

![Week 3, Lab 3 screenshot](./_screenshots/week03/screenshot.png)

#### Objectives
1. Configure IPv4 Addressing and Verify Connectivity
2. Configure IPv6 Addressing and Verify Connectivity

### [Week 4 (Lab 4)](./week04/lab/): Implement VLANs and Trunking
[Task](./week04/lab/routers_and_routing_basics_week04_lab_implement_vlans_and_trunking.pdf) | [Packet Tracer Solution (.pka)](./week04/lab/solution/routers_and_routing_basics_week04_lab_implement_vlans_and_trunking.pka) | [cli_vlan_commands.pdf (resources)](./week04/resources/cli_vlan_commands.pdf)

This laboratory exercise introduces students to the configuration of VLANs and trunking.

![Week 4, Lab 4 screenshot](./_screenshots/week04/screenshot.png)

#### Objectives
1. Configure VLANs
2. Assign Ports to VLANs
3. Configure Static Trunking
4. Configure Dynamic Trunking

### [Week 5 (Lab 5)](./week05/lab/): Configure Router on a Stick Inter VLAN Routing
[Task 1 (configure_router_on_a_stick_inter_vlan_routing.pdf)](./week05/lab/routers_and_routing_basics_week05_lab_configure_router_on_a_stick_inter_vlan_routing.pdf) | [Task 2 (password_recovery_on_a_cisco_router_&_switch.pdf)](./week05/lab/routers_and_routing_basics_week05_lab_password_recovery_on_a_cisco_router_&_switch.pdf)

This laboratory exercise introduces students to the configuration of router-on-a-stick inter-VLAN routing & password recovery on a Cisco router & switch.

![Week 5, Lab 5 screenshot](./_screenshots/week05/screenshot.png)

#### Objectives
1. Configure Console Passwords on Router & Switch
2. Perform Password Recovery on Router
3. Perform Password Recovery on Switch
4. Add VLANs to a Switch
5. Configure Subinterfaces
5. Test Connectivity with Inter-VLAN Routing

### [Week 6 (Lab 6)](./week06/lab/): Configure DHCPv4
[Task](./week06/lab/routers_and_routing_basics_week06_lab_configure_dhcpv4.pdf) | [Packet Tracer Solution (.pka)](./week06/lab/solution/routers_and_routing_basics_week06_lab_configure_dhcpv4.pka) | [cli_dhcp_commands.pdf (resources)](./week06/resources/cli_dhcp_commands.pdf)

This laboratory exercise introduces students to the configuration of DHCPv4.

![Week 6, Lab 6 screenshot](./_screenshots/week06/screenshot.png)

#### Objectives
1. Configure a Router as a DHCP Server
2. Configure DHCP Relay
3. Configure a Router as a DHCP Client
4. Verify DHCP and Connectivity

### [Week 7 (Lab 7)](./week07/lab/): Configuring IPv4 Static and Default Routes
[Task](./week07/lab/routers_and_routing_basics_week07_lab_configuring_ipv4_static_and_default_routes.pdf)

This laboratory exercise introduces students to the configuration of IPv4 static and default routes.

![Week 7, Lab 7 screenshot](./_screenshots/week07/screenshot.png)

#### Objectives
1. Set Up the Topology and Initialize Devices
2. Configure Basic Device Settings and Verify Connectivity
3. Configure Static Routes
    - Configure a recursive static route.
    - Configure a directly connected static route.
    - Configure and remove static routes.
4. Configure and Verify a Default Route

### [Week 8 (Lab 8)](./week08/lab/): Configuring IPv6 Static and Default Routes
[Task](./week08/lab/routers_and_routing_basics_week08_lab_configuring_ipv6_static_and_default_routes.pdf)

This laboratory exercise introduces students to the configuration of IPv6 static and default routes.

![Week 8, Lab 8 screenshot](./_screenshots/week08/screenshot.png)

#### Objectives
1. Build the Network and Configure Basic Device Settings
    - Enable IPv6 unicast routing and configure IPv6 addressing on the Routers and PCs.
    - Use show commands to verify IPv6 settings.
2. Configure IPv6 Static and Default Routes
    - Configure a directly attached IPv6 static route.
    - Configure a recursive IPv6 static route.
    - Configure a default IPv6 static route

### Week 10 (CA 1): Practical Packet Tracer exam
> Practical Packet Tracer exam covering all topics from this module.

### Week 12 (CA 2): MCQ Test
> This exam covers the content of all lectures to date.  
> It is an MCQ with 50 questions.
