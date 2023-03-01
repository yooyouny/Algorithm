def min_num_of_swap(i, j, k, shapes, shapes_info):
  count_j_in_i = 0
  count_k_in_i = 0
  count_j_in_k = 0
  count_k_in_j = 0

  for l in range(shapes_info[i]):
    if shapes[l] == j:
      count_j_in_i += 1
    if shapes[l] == k:
      count_k_in_i += 1

  for l in range(shapes_info[i], shapes_info[i] + shapes_info[j]):
    if shapes[l] == k:
      count_k_in_j += 1

  for l in range(shapes_info[i] + shapes_info[j], len(shapes)):
    if shapes[l] == j:
      count_j_in_k += 1

  return count_j_in_i + count_k_in_i + max(count_j_in_k, count_k_in_j)



size = int(input())
shapes = list(map(int, input().split()))
shapes_info = [0, 0, 0, 0]

for i in shapes:
  shapes_info[i] += 1

res = min_num_of_swap(1, 2, 3, shapes, shapes_info)
res = min(res, min_num_of_swap(1, 3, 2, shapes, shapes_info))
res = min(res, min_num_of_swap(2, 1, 3, shapes, shapes_info))
res = min(res, min_num_of_swap(2, 3, 1, shapes, shapes_info))
res = min(res, min_num_of_swap(3, 1, 2, shapes, shapes_info))
res = min(res, min_num_of_swap(3, 2, 1, shapes, shapes_info))

print(res)