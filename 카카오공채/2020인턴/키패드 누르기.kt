class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var position = arrayOf(Pair(3,1),Pair(0,0),Pair(0,1),
                Pair(0,2),Pair(1,0),Pair(1,1),
                Pair(1,2),Pair(2,0),Pair(2,1),
                Pair(2,2),Pair(3,0),Pair(3,2))
        var L = 10
        var R = 11

        numbers.forEach {
            if(it == 1 || it == 4 || it == 7){
                answer += 'L'
                L = it
            }
            else if(it == 3 || it == 6 || it == 9){
                answer += 'R'
                R = it
            }
            else{
                var itL = Math.abs(position[it].first-position[L].first) + Math.abs(position[it].second-position[L].second)
                var itR = Math.abs(position[it].first-position[R].first) + Math.abs(position[it].second-position[R].second)
                if(itL < itR){
                    answer += 'L'
                    L = it
                }
                else if(itL > itR){
                    answer += 'R'
                    R = it
                }
                else{
                    if(hand == "right"){
                        answer += 'R'
                        R = it
                    }
                    else{
                        answer += 'L'
                        L = it
                    }
                }
            }
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    print(sol.solution(intArrayOf(1,3,4,5,8,2,1,4,5,9),"right"))
}