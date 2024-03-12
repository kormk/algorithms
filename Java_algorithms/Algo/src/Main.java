import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    static int result = 0;
    static int recur = 0;
    static int[] depth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[node];
        visited = new boolean[node];
        depth = new int[node];

        for(int i = 0; i < node ; i++)
        {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge ; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            nodes[s].add(d);
            nodes[d].add(s);
        }

        for(int i=0; i<node; i++){
            DFS(i);
            visited = new boolean[node];
        }


        int res = 0;

        for(int i = 0 ; i< depth.length - 1; i++)
        {
            if(depth[i] >= 4)  {
                res = 1;
                break;
            }
        }

        System.out.println(res);

    }

    public static void DFS(int index)
    {
        visited[index] = true;
        for(int i:nodes[index])
        {
            if(!visited[i]) {
                visited[i] = true;
                depth[index]++;
                DFS(i);
                visited[i] = false;
            }
        }
    }
}