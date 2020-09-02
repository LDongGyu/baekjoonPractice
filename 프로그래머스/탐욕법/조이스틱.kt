import java.util.*
import kotlin.math.absoluteValue

class Solution {
    fun solution(name: String): Int {
        var answer = 0
        var index = 0
        var list = mutableListOf<Int>()

        name.forEach {
            if(it -'A' <= 13){
                answer += it-'A'
            }
            else{
                answer += 26 - (it-'A')
            }
        }

        for(i in 1..name.lastIndex){
            if(name[i] != 'A'){
                list.add(i)
            }
        }

        while(!list.isEmpty()){
            var leftMin = 0
            var rightMin = 0

            if((index-list.get(0)).absoluteValue < name.lastIndex-(index-list.get(0)).absoluteValue+1){
                leftMin = (index-list.get(0)).absoluteValue
            }
            else{
                leftMin = name.lastIndex-(index-list.get(0)).absoluteValue+1
            }

            if((index-list.last()).absoluteValue < name.lastIndex-(index-list.last()).absoluteValue+1){
                rightMin = (index-list.last()).absoluteValue
            }
            else{
                rightMin = name.lastIndex-(index-list.last()).absoluteValue+1
            }

            if(leftMin > rightMin){
                answer += rightMin
                index = list.last()
                list.removeAt(list.lastIndex)
            }
            else{
                answer += leftMin
                index = list.get(0)
                list.removeAt(0)
            }
        }

        return answer
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution("JAN")

    print(result)
}