import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] input = new long[num];

        int count = 0;

        for(int i = 0; i < num ; i++)
        {
            input[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(input);

        int i,j;
        long find;

        for(int k = 0; k < num ; k++)
        {
            find = input[k];
            i = 0;
            j = num-1;

            while(i < j)
            {
                if(input[i] + input[j] == find){
                    if(i != k && j != k)
                    {
                        count++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (input[i] + input[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}