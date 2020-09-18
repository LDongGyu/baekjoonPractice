class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = -1

        var set = Array<MutableList<Int>>(9,{i-> mutableListOf()})
        var str = ""
        for(i in 1..8){
            for(j in 1..i){
                str += N.toString()
            }
            set[i].add(str.toInt())
            str = ""
        }

        for(i in 1..8){
            for(j in 1..i){
                for(h in 0..set[j].lastIndex){
                    for(k in 0..set[i-j].lastIndex){
                        if(!set[i].contains(set[j][h] + set[i-j][k]))
                            set[i].add(set[j][h] + set[i-j][k])
                        if(!set[i].contains(set[j][h] - set[i-j][k]))
                            set[i].add(set[j][h] - set[i-j][k])
                        if(!set[i].contains(set[i-j][k]-set[j][h]))
                            set[i].add(set[i-j][k]-set[j][h])
                        if(!set[i].contains(set[j][h] * set[i-j][k]))
                            set[i].add(set[j][h] * set[i-j][k])
                        if(set[i-j][k] != 0 && !set[i].contains(set[j][h] / set[i-j][k]))
                            set[i].add(set[j][h] / set[i-j][k])
                        if(set[j][h] != 0 && !set[i].contains(set[i-j][k] / set[j][h]))
                            set[i].add(set[i-j][k] / set[j][h])
                    }
                }
            }
            if(set[i].contains(number)){
                answer = i
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