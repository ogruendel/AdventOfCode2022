game = open("input", "r")
score = 0
for line in game:
    if line[2] == "X":
        # Rock
        score += 1
        if line[0] == "A":
            # Rock
            score += 3
        elif line[0] == "C":
            # Scissors
            score += 6
    elif line[2] == "Y":
        # Paper
        score += 2
        if line[0] == "B":
            # Paper
            score += 3
        elif line[0] == "A":
            # Rock
            score += 6
    elif line[2] == "Z":
        # Scissors
        score += 3
        if line[0] == "C":
            # Scissors
            score += 3
        elif line[0] == "B":
            # Paper
            score += 6

game.close()
print(f'Part 1 solution: {score}')
score = 0
game = open("input", "r")

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
