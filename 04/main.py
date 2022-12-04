space = open("input", "r")
count = 0

for line in space:
    elf1 = line.strip().split(",")[0]
    elf2 = line.strip().split(",")[1]

    if int(elf1.split("-")[0]) >= int(elf2.split("-")[0]):
        if int(elf1.split("-")[1]) <= int(elf2.split("-")[1]):
            count += 1
    if int(elf2.split("-")[0]) >= int(elf1.split("-")[0]):
        if int(elf2.split("-")[1]) <= int(elf1.split("-")[1]):
            count += 1
    if elf1 == elf2:
        count -= 1

print(f'Part 1 solution: {count}')
count = 0
space.close()

space = open("input", "r")

for line in space:
    elf1 = line.strip().split(",")[0]
    elf2 = line.strip().split(",")[1]

    x = range(int(elf1.split("-")[0]), int(elf1.split("-")[1]) + 1)
    y = range(int(elf2.split("-")[0]), int(elf2.split("-")[1]) + 1)

    if set(x).intersection(y):
        count += 1

print(f'Part 2 solution: {count}')
