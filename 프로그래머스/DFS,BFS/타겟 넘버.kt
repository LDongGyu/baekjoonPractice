class Solution {

    lateinit var numArray: IntArray
    var targetNum = 0
    var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {

        numArray = numbers
        targetNum = target

        dfs(0,0)

        return answer
    }

    fun dfs(index: Int, sum: Int){
        if(index == numArray.size){
            if(sum == targetNum){
                answer++
            }
            return
        }

        dfs(index+1,sum+numArray[index])
        dfs(index+1,sum-numArray[index])
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution(intArrayOf(1,1,1,1,1),3)
    print(result)
}