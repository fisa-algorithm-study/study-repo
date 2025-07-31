def solution(data, ext, val_ext, sort_by):
    extDict = {"code": 0, "date": 1, "maximum": 2, "remain": 3}
    answer = []
    for d in data:
        if d[extDict[ext]] < val_ext:
            answer.append(d)
    

    answer.sort(key=lambda x: x[extDict[sort_by]])
    return answer