arr_str = input()
search_str = input()

count = 0
idx = 0

while idx <= len(arr_str) - len(search_str):
    if arr_str[idx : idx + len(search_str)] == search_str:
        count += 1
        idx += len(search_str)
    else:
        idx += 1
        
print(count)