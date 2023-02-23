n = int(input())
binary = bin(n)[2:]
binary = binary[::-1]
print(int(binary, 2))