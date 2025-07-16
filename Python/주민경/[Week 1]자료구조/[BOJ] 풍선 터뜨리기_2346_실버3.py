N = int(input())
balloons = list(map(int, input().split()))
popped_balloons = set([0])
pointer = 0
result = [1]

while len(popped_balloons) < len(balloons):
  step = balloons[pointer]
  move = abs(step)
  if step > 0:
    direction = 1
  else:
    direction = -1

  while move > 0:
    pointer = (pointer + direction) % N
    if pointer not in popped_balloons:
      move -= 1

  popped_balloons.add(pointer)
  result.append(pointer + 1)

for p in result:
  print(p , end=" ")  
