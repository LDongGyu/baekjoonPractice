class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = Array<IntArray>(arr1.size,{ IntArray(arr1[0].size,{ i->0}) })

        for(i in 0..arr1.lastIndex){
            for(j in 0..arr1[0].lastIndex){
                answer[i][j] = arr1[i][j] + arr2[i][j]
            }
        }

//        var answer = Array<IntArray>(arr1.size) { i ->
//            Array<Int>(arr1[0].size) { j ->
//                arr1[i][j] + arr2[i][j]
//            }.toIntArray()
//        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(2,5))
}