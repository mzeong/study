#include <string>
#include <vector>
#include <stack>

using namespace std;

struct Node {
    int idx;
    Node* prev;
    Node* next;
    Node(int idx, Node* prev, Node* next) : idx(idx), prev(prev), next(next) {}
};

string solution(int n, int k, vector<string> cmd) {
    Node* cur = new Node(0, NULL, NULL);    
    Node* cursor = cur;
    for (int i = 1; i < n; i++) {
        cur->next = new Node(i, cur, NULL);
        cur = cur->next;
    }
    
    for (int i = 0; i < k; i++) {
        cursor = cursor->next;
    }
    
    stack<Node*> st;
    for (const auto& c : cmd) {
        if (c[0] == 'C') {
            st.push(cursor);
            if (cursor->prev != NULL) cursor->prev->next = cursor->next;
            if (cursor->next != NULL) cursor->next->prev = cursor->prev;
            
            if (cursor->next == NULL) cursor = cursor->prev;
            else cursor = cursor->next;
        } else if (c[0] == 'Z') {
            Node* node = st.top();
            st.pop();
            if (node->prev != NULL) node->prev->next = node;
            if (node->next != NULL) node->next->prev = node;
        } else {
            int degree = stoi(c.substr(2));
            
            if (c[0] == 'U') {
                while (degree--) cursor = cursor->prev;
            }
            else {
                while(degree--) cursor = cursor->next;
            }
        }
    }
    
    string answer(n, 'O');
    while(!st.empty()) {
        answer[st.top()->idx] = 'X';
        st.pop();
    }
    return answer;
}
