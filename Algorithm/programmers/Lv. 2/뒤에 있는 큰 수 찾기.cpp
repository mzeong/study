#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    
    int size = numbers.size();
    answer.resize(size);
    
    stack<int> st;
    for (int i = size - 1; i >= 0; i--) {
        while (!st.empty() && st.top() <= numbers[i]) st.pop();
        if (st.empty()) answer[i] = -1; 
        else answer[i] = st.top();
        st.push(numbers[i]);
    }
    
    return answer;
}
