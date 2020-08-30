class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var first = intArrayOf(1,2,3,4,5)
        var second = intArrayOf(2,1,2,3,2,4,2,5)
        var third = intArrayOf(3,3,1,1,2,2,4,4,5,5)

        var cntList = mutableListOf<Pair<Int,Int>>(Pair(1,0),Pair(2,0),Pair(3,0))

        answers.mapIndexed { index, i ->
            if(i == first[index%first.size]){
                cntList.set(0,Pair(1,cntList.get(0).second+1))
            }
            if(i == second[index%second.size]){
                cntList.set(1,Pair(2,cntList.get(1).second+1))
            }
            if(i == third[index%third.size]){
                cntList.set(2,Pair(3,cntList.get(2).second+1))
            }
        }

        cntList.sortWith(Comparator { o1, o2 ->
            return@Comparator o2.second-o1.second
        })

        cntList.map {
            if(it.second == cntList[0].second){
                answer.add(it.first)
            }
        }
        answer.sort()

        return answer.toIntArray()
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution(intArrayOf(1,1,2,4,5))

    print(result)
}