# Week 04 — Lab 4: implement VLANs and trunking

**Module:** Routers and Routing Basics (`COMP H1021`)  
**Semester:** 2 (Year 1), folder `sem02`

[Module README](../README.md)

## What this week is for

Lab 4 is a Packet Tracer activity on VLANs and trunking for a branch office with three 2960 switches (SWA, SWB and SWC). The sheet gives a VLAN table (Admin 10, Accounts 20, HR 30, Voice 40, Management 99, Native 100), the port assignments, and management addresses on VLAN 99 that must not be able to ping each other. The tasks are a static trunk between SWA and SWB with dynamic trunking turned off, and a dynamic trunk from SWA's G0/2 port to SWC, using the default negotiation. The Packet Tracer file is listed below.

## Screenshots

![Week 04 screenshot](../.screenshots/week04/screenshot.png)

*Packet Tracer VLAN topology (switches, PCs and an IP phone) beside the lab sheet.*

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/routers_and_routing_basics_week04_lab_implement_vlans_and_trunking.pdf`](lab/routers_and_routing_basics_week04_lab_implement_vlans_and_trunking.pdf) | The Packet Tracer lab sheet (2 pages): create the VLANs, assign the ports, configure a static trunk and a dynamic trunk, and set the management addresses. |
| [`lab/solution/routers_and_routing_basics_week04_lab_implement_vlans_and_trunking.pka`](lab/solution/routers_and_routing_basics_week04_lab_implement_vlans_and_trunking.pka) | Packet Tracer file for this lab. Packet Tracer saves files in an encrypted format, so this file opens only in Cisco Packet Tracer and its contents are not shown in the repository. The task it solves is the PDF listed above. |
| [`resources/cli_vlan_commands.pdf`](resources/cli_vlan_commands.pdf) | A two-page command reference for VLANs: creating them, assigning ports and the trunk commands. |
