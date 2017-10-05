import sys


def longest_increasing_subsequence_n_2(sequence):

    subsequence = []
    longest_subsequence_sizes = [1]
    backpointers = [-1]
    global_longest_subsequence_size = -1
    index_subsequence_end = -1

    for i in range(1, len(sequence)):
        longest_subsequence_size = 1
        backpointer = -1

        for j in reversed(range(i)):
            if sequence[i] > sequence[j] and longest_subsequence_sizes[j] >= longest_subsequence_size:
                backpointer = j
                longest_subsequence_size = longest_subsequence_sizes[j]+1

        longest_subsequence_sizes.append(longest_subsequence_size)
        backpointers.append(backpointer)

        if longest_subsequence_size > global_longest_subsequence_size:
            global_longest_subsequence_size = longest_subsequence_size
            index_subsequence_end = i

    for i in range(longest_subsequence_sizes[index_subsequence_end]):
        subsequence.append(sequence[index_subsequence_end])
        index_subsequence_end = backpointers[index_subsequence_end]

    return subsequence


def longest_increasing_subsequence_n_log_n(sequence):

    min_number = [sequence[0]]
    longest_subsequence_sizes = [1]

    for i in range(1, len(sequence)):
        elem = sequence[i]
        end = False
        for j in reversed(range(len(min_number))):
            if elem > min_number[j]:
                end = True
                longest_subsequence_sizes.append(j + 2)
                if j + 1 == len(min_number):
                    min_number.append(elem)
                else:
                    if min_number[j+1] > elem:
                        min_number[j+1] = elem
                break
        if elem < min_number[0]:
            min_number[0] = elem
        if not end:
            longest_subsequence_sizes.append(1)

    subsequence = min_number
    return subsequence


if __name__ == '__main__':
    sequence = sys.argv[1:len(sys.argv)]
    print(sequence)
    sequence = list(map(int, sequence))
    print(sequence)
    print(longest_increasing_subsequence_n_log_n(sequence))

