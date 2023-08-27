#include <string>
#include <vector>
#include <algorithm>

using namespace std;

struct Node {
    int index, x, y;
    Node* left;
    Node* right;
    Node(int i, int _x, int _y) : index(i), x(_x), y(_y), left(nullptr), right(nullptr) {}
};

bool compareNodes(const Node& a, const Node& b) {
    if (a.y == b.y) return a.x < b.x;
    else return a.y > b.y;
}

void insertNode(Node* parent, Node* child) {
    if (child->x < parent->x) {
        if (parent->left == nullptr) parent->left = child;
        else insertNode(parent->left, child);
    } else {
        if (parent->right == nullptr) parent->right = child;
        else insertNode(parent->right, child);
    }
}

vector<int> preorder(Node* root) {
    vector<int> result;
    if (root) {
        result.push_back(root->index);
        vector<int> left = preorder(root->left);
        result.insert(result.end(), left.begin(), left.end());
        vector<int> right = preorder(root->right);
        result.insert(result.end(), right.begin(), right.end());
    }
    return result;
}

vector<int> postorder(Node* root) {
    vector<int> result;
    if (root) {
        vector<int> left = postorder(root->left);
        result.insert(result.end(), left.begin(), left.end());
        vector<int> right = postorder(root->right);
        result.insert(result.end(), right.begin(), right.end());
        result.push_back(root->index);
    }
    return result;
}

vector<vector<int>> solution(vector<vector<int>> nodeinfo) {
    vector<Node> nodes;
    for (int i = 0; i < nodeinfo.size(); i++) {
        nodes.emplace_back(i+1, nodeinfo[i][0], nodeinfo[i][1]);
    }
    sort(nodes.begin(), nodes.end(), compareNodes);

    Node* root = &nodes[0];
    for (int i = 1; i < nodes.size(); i++) {
        insertNode(root, &nodes[i]);
    }

    vector<vector<int>> answer(2);
    answer[0] = preorder(root);
    answer[1] = postorder(root);
    return answer;
}
