import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        var index = 0
        var max = '0'
        var answer = StringBuilder()

        for(i in 0..number.length-k-1){
            max = '0'
            for(j in index..k+i){
                if(max < number[j]){
                    max = number[j]
                    index = j+1
                }
            }
            answer.append(max)
        }
        return answer.toString()
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution("1924",2)

    print(result)
}