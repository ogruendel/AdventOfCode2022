rucksacks = open("input", "r")
key = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
count = 0

for line in rucksacks:
    start = line[0:int(len(line.strip()) / 2)]
    end = line[int(len(line.strip()) / 2):len(line.strip())]

    for char in start:
        if char in end:
            count += key.index(char) + 1
            break
rucksacks.close()
print(f'Part 1 solution: {count}')
count = 0

rucksacks = open("input", "r")
group = []

for line in rucksacks:
    group.append(line)
    if len(group) == 3:
        for char in group[0]:
            if char in group[1]:
                if char in group[2]:
                    count += key.index(char) + 1
                    group.clear()
                    break

print(f'Part 2 solution: {count}')
