a = input()
b = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
c= []

for i in b:
    c.append(a.count(i))

c_max = max(c)
print(c_max)
