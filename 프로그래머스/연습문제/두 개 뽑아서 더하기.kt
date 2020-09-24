class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var list = mutableListOf<Int>()
        
        for(i in 0..numbers.lastIndex){
            for(j in i+1..numbers.lastIndex){
                var temp = numbers[i] + numbers[j]
                if(!list.contains(temp)) list.add(temp)
            }
        }

        answer = list.sorted().toIntArray()
        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(intArrayOf(2,1,3,4,1))

    print(result)
}