class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()
        var list = mutableListOf<Int>()

        arr.forEach {
            if(it % divisor == 0) list.add(it)
        }
        if(list.isEmpty()) list.add(-1)
        answer = list.sorted().toIntArray()

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(intArrayOf(5,9,7,10),5)

    print(result)
}