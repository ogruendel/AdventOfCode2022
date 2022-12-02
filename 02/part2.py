game = open("input", "r")
score = 0

for line in game:
    if line[0] == "A":
        # Rock
        if line[2] == "X":
            score += 3
        elif line[2] == "Y":
            score += 4
        elif line[2] == "Z":
            score += 8
    elif line[0] == "B":
        # Paper
        if line[2] == "X":
            score += 1
        elif line[2] == "Y":
            score += 5
        elif line[2] == "Z":
            score += 9
    elif line[0] == "C":
        # Scissors
        if line[2] == "X":
            score += 2
        elif line[2] == "Y":
            score += 6
        elif line[2] == "Z":
            score += 7

print(f'Part 2 solution: {score}')