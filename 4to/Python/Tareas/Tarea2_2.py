

def InsertionSort(bucket):
    for p in range(1, len(bucket)):
        pivote = bucket[p]
        i = p - 1
        while i >= 0 and pivote < bucket[i]:
            bucket[i + 1] = bucket[i]
            i -= 1
        bucket[i + 1] = pivote


def BucketSort(array):
    lar = len(array)
    buckets = [[] for x in range(lar)]

    for e in array:
        b = min(int(lar * e), lar - 1)
        bucket = buckets[b]
        bucket.append(e)

    for bucket in buckets:
        InsertionSort(bucket)

    result = []
    for bucket in buckets:
        result.extend(bucket)

    return result


array_A = [12,4,42,65,32,89,5001,5,53,78]
print("Array A:", BucketSort(array_A))

array_B = [3,90,4,78,645,12,0,32,5]
print("Array B:", BucketSort(array_B))

array_C = [11,65,22,90,54,21,56]
print("Array C:", BucketSort(array_C))

array_D = []
print("Array D:", BucketSort(array_D))