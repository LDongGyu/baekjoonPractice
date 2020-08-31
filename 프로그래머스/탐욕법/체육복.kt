class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n - lost.size
        var lostList = lost.toMutableList()
        var reserveList = reserve.toMutableList()
        var list = mutableListOf<Int>()

        lost.forEach {
            if(reserveList.contains(it)){
                list.add(it)
            }
        }

        answer += list.size
        list.forEach {
            lostList.remove(it)
            reserveList.remove(it)
        }

        lostList.forEach {
            if(reserveList.contains(it-1)){
                reserveList.remove(it-1)
                answer++
            }
            else if(reserveList.contains(it+1)){
                reserveList.remove(it+1)
                answer++
            }
        }

        return answer
    }

    fun solution2(n: Int, lost: IntArray, reserve: IntArray): Int {

        var answer = n
        var lostSet = lost.toSet() - reserve.toSet()
        var reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

        for (i in lostSet) {
            when {
                i + 1 in reserveSet -> reserveSet.remove(i + 1)
                i - 1 in reserveSet -> reserveSet.remove(i - 1)
                else -> answer--
            }
        }
        return answer
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution(7, intArrayOf(2,4), intArrayOf(4,5))

    print(result)
}