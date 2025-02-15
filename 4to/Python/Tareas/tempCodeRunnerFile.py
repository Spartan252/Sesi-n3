
    output = [random.randrange(0,10) for j in range(i*3)]
    print(output)
    expected = output.copy()
    expected.sort()
    quick_sort_test = quick_sort(output, 0, len(output)-1)
    select_test = select(output, 0, len(output)-1, i)
    print("Output quick_sort:")
    print(quick_sort_test)
    print("Output select: i = "+str(i))
    print(select_test)
    print("Expected:")
    print(expected)

    assert output == quick_sort_test, "Failed test"