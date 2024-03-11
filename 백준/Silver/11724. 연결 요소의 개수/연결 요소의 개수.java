import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[node + 1];
        visited = new boolean[node+1];

        int count = 0;

        for(int i = 1 ; i < node+1 ; i ++)
        {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < edge ; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodes[s].add(e);
            nodes[e].add(s);
        }

        for(int i = 1 ; i < node+1; i++)
        {
            if(!visited[i])
            {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);

    }

    static void DFS(int index)
    {
        if(visited[index]) return;

        visited[index] = true;
        for(int i : nodes[index]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }



}