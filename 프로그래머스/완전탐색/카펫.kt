class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = IntArray(2)

        var yellowSet = mutableSetOf<Set<Int>>()

        for(i in 1.. yellow/2+1){
            if(yellow%i == 0){
                var set = setOf(i,yellow/i)
                yellowSet.add(set)
            }
        }

        for(i in 0..yellowSet.size-1){
            yellowSet.forEach { i ->
                if(i.first()*2+i.last()*2+4 == brown){
                    if(i.first()>i.last()) {
                        answer[0] = i.first()+2
                        answer[1] = i.last()+2
                    }
                    else{
                        answer[1] = i.first()+2
                        answer[0] = i.last()+2
                    }
                }
            }
        }
        return answer
    }

    fun solution2(brown: Int, red: Int): IntArray {
        return (1..red)
                .filter { red % it == 0 }
                .first { brown == (red / it * 2) + (it * 2) + 4 }
                .let { intArrayOf(red / it + 2, it + 2) }
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution(8,1)

    print(result)
}