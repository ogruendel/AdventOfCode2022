calories = open("calories", "r")
count = 0
counts = []
for line in calories:
    if line != "\n":
        count += int(line)
    else:
        counts.append(count)
        count = 0
print(f'Part 1 solution: {max(counts)}')

# Part 2:
counts.sort(reverse=True)
print(f'Part 2 solution: {counts[0] + counts[1] + counts[2]}')
