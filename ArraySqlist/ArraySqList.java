package DataStructure.ArraySqlist;


public class ArraySqList<ElemType> {
    int MaxSize; //最大长度
    ElemType data[]; //数组实现顺序表
    int length = 0; //当前顺序表长度

    public ArraySqList() {
        //默认顺序表长度为10
        MaxSize = 10;
        data = (ElemType[]) new Object[MaxSize];
    }

    public ArraySqList(int maxSize) {
        MaxSize = maxSize;
        data = (ElemType[]) new Object[MaxSize];
    }

    //扩大数组
    private void Increase() {
        MaxSize = MaxSize + 5;
        Object temp[] = new Object[MaxSize];
        for (int i = 0; i < length; i++) {
            //复制数组
            temp[i] = data[i];
        }
        //将新数组交给data
        data = (ElemType[]) temp;
    }

    /*
      将元素添加到顺序表的指定位置
      问题规模n = length(表长)
      时间复杂度：最好时间复杂度O(1),插入位置在表尾，不需移动元素
                最坏时间复杂度O(n)，插入位置在表头，需要移动n个元素
                平均时间复杂度O(n)，如果插入到表中的位置概率相同，则执行次数n(n+1)/2 * 1/(n+1) = n/2
     */
    public void add(ElemType e, int index) {
        if (index > length+1 || index < 0)
            throw new IndexOutOfBoundsException();
        if (length == MaxSize)
            Increase();
            for (int j = length; j >= index; j--)
                data[j] = data[j - 1];   //将length-index+1个元素往后移动
            data[index-1] = e;
            length++;
    }
        public void add (ElemType e){ //往后增加元素
        if (length == MaxSize)
            Increase();
            data[length] = e;
            length++;
        }

    /*
     将元素从顺序表中移除
     问题规模n = length(表长)
     时间复杂度：最好时间复杂度O(1),删除位置在表尾，不需移动元素
               最坏时间复杂度O(n)，删除位置在表头，需要移动n个元素
               平均时间复杂度O(n)，如果删除表中的元素位置概率相同，则执行次数n(n+1)/2 * 1/(n+1) = n/2
    */
        public ElemType remove (int index){
            if (index > length+1 || index < 0) //非法访问处理
                throw new IndexOutOfBoundsException();
            ElemType result = data[index-1];
            for (int i = index; i < data.length; i++)
                data[i-1] = data[i];
            length--;
            return result;
        }

        //从顺序表中指定位置获取元素 O(1)
        public ElemType get(int index){
            if(index<1 || index>length)
            return null;
            return data[index-1];
        }

        @Override
        //打印顺序表
        public String toString () {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++){
                if(i == length - 1)
                    sb.append(data[i]);
                else
                    sb.append(data[i]+" ");
                }
            return "["+sb.toString()+"]";
        }
    }


