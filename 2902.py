line,a = input().split('-') , []
i=""
for s in line:
    a.append(s[0])

for result in a:
    i += result
print(i)