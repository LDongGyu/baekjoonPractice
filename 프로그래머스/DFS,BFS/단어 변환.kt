class Solution {

    var min = Integer.MAX_VALUE
    var targetStr = ""
    lateinit var check: BooleanArray
    lateinit var wordArray: Array<String>

    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        targetStr = target
        check = BooleanArray(words.size)
        wordArray = words

        dfs(begin,0)
        if(min < Integer.MAX_VALUE) answer = min
        else answer = 0

        return answer
    }

    fun dfs(str: String, cnt: Int){
        if(str == targetStr){
            if(min > cnt){
                min = cnt
            }
            return
        }

        for(i in 0..wordArray.lastIndex){
            if(!check[i] && isChange(str,wordArray[i])){
                check[i] = true
                dfs(wordArray[i],cnt+1)
                check[i] = false
            }
        }
    }

    fun isChange(before: String, after: String): Boolean{
        var cnt = 0

        for(i in 0..before.lastIndex){
            if(before[i] == after[i]) cnt++
        }

        if(cnt == before.lastIndex){
            return true
        }

        return false
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution("hit","cog",arrayOf("hot","dot","dog","lot","log","cog"))
    print(result)
}