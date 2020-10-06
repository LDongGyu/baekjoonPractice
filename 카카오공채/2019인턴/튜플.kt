class Solution {
    fun solution(s: String): IntArray {
        var parsing = s.substring(2,s.lastIndex-1).split("},{")
        var array = Array<List<String>>(parsing.size,{i-> listOf()})

        for(string in parsing){
            var numList = string.split(",")
            array[numList.size-1] = numList
        }

        var answer = IntArray(array.size)

        answer[0] = array[0][0].toInt()

        for(i in 1..array.lastIndex){
            for(j in 0..array[i].lastIndex){
                if(!answer.contains(array[i][j].toInt())){
                    answer[i] = array[i][j].toInt()
                    break
                }
            }
        }

        return answer

//        return s.substring(2 until s.length-2)
//                .split("},{")
//                .asSequence()
//                .map { it.split(",").map { num -> num.toInt() } }
//                .toList()
//                .sortedBy { it.size }
//                .fold(setOf<Int>()) { acc, list -> acc.union(list) }
//                .toIntArray()
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))
}