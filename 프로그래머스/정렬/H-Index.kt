class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0

        citations.sorted()
                .mapIndexed { index, i ->
                    if(citations.size-index <= i)
                        return citations.size-index
                }
        return answer
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution(intArrayOf(31,66))

    print(result)
}