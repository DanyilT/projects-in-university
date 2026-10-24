# Week 02 — Lab 0: networking VMs (VirtualBox)

**Module:** Network Security (`DFCS H3015`)  
**Semester:** 6 (Year 3), folder `sem06`

[Module README](../README.md)

## What this week is for

Lecture 2 was network threats and mitigation. Lab 0 creates virtual machines and networks them. Part 1 networks two VMs together: create a Xubuntu VM in VirtualBox and install the guest OS (2 GB of RAM, 1 CPU and a 20 GB disk), create a second VM by cloning the first one, and connect the two VMs to the same internal network in the 10.10.10.0/26 address range. Part 2 connects VMs through a gateway: create a third VM and connect it to a virtual network, add a second virtual adapter to the second VM and connect it to the third, and configure the second VM as a gateway between the two VMs. The course page has four VM tutorials for the same steps (creating a VM with a guest OS, attaching VMs to the same virtual network, connecting VMs to the Internet and downloading apps, and putting a VM between two other VMs).

## Files

| File | What it contains |
|---|---|
| [`README.md`](README.md) | This README. |
| [`lab/network_security_week02_lab.pdf`](lab/network_security_week02_lab.pdf) | The lab sheet (19 pages): Lab 0 - Networking VMs, parts 1 and 2. |
