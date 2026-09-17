Test n=4:
Có:
union(0, 1) → leader = [1, 1, 2, 3]
union(1, 2) → leader = [1, 2, 2, 3] (chỉ phần tử có leader == leader[1] == 1 bị đổi thành leader[2] == 2)
union(0, 3) → tại bước này leader[0] = 1, leader[3] = 3, nên chỉ phần tử có leader[i] == 1 bị đổi thành 3.
Nhưng lúc này không còn phần tử nào có leader == 1 (index 0 đã bị đổi ở bước 2 rồi), nên vòng lặp
không đổi gì cả → leader = [1, 2, 2, 3]

Kết quả:

find(0) = leader[0] = 1
find(3) = leader[3] = 3 
Do union(0,3) nên chúng cùng 1 tập hợp nhma find(0)!=find(3)
Tets case này sai