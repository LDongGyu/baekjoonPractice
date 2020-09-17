class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = -1

        var set = Array<MutableList<Int>>(9,{i-> mutableListOf()})
        var str = ""
        for(i in 0..7){
            for(j in 0..i){
                str += N.toString()
            }
            set[i].add(str.toInt())
            str = ""
        }

        for(i in 1..8){
            for(j in 0..i-1){
                for(h in 0..set[j].lastIndex){
                    for(k in 0..set[i-j-1].lastIndex){
                        if(!set[i].contains(set[j][h] + set[i-j-1][k]))
                            set[i].add(set[j][h] + set[i-j-1][k])
                        if(!set[i].contains(set[j][h] - set[i-j-1][k]))
                            set[i].add(set[j][h] - set[i-j-1][k])
                        if(!set[i].contains(set[j][h] * set[i-j-1][k]))
                            set[i].add(set[j][h] * set[i-j-1][k])
                        if(set[i-j-1][k] != 0 && !set[i].contains(set[j][h] / set[i-j-1][k])){
                            set[i].add(set[j][h] / set[i-j-1][k])
                        }
                    }
                }
            }
            if(set[i].contains(number)){
                answer = i+1
                break
            }
        }

        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(5,12)

    print(result)
}