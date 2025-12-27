## Problem Statment 

Design a File Compression Utility that supports multiple compression algorithms such as ZIP, GZIP, and BZIP2.
The system should allow clients to choose a compression algorithm at runtime without modifying the core compression logic. Each compression technique follows a different algorithm, but the overall workflow of compressing a file remains the same.
The solution must be easily extensible so that new compression algorithms can be added in the future without changing existing code. 

### Example flow 

```text
Input  : fileName = "logs.txt", compressionType = GZIP
Output : logs.txt compressed using GZIP algorithm
```
