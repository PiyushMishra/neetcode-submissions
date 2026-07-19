func isAnagram(s string, t string) bool {

    if len(s) != len(t) {
        return false
    }

    freq := make([]int, 26)

    for i := 0; i < len(s); i++ {
        freq[rune(s[i] - 'a')] += 1
        freq[rune(t[i] - 'a')] -= 1 
    }

    for _, value := range freq {
        if value != 0 {
            return false
        }
    }

    return true

}
