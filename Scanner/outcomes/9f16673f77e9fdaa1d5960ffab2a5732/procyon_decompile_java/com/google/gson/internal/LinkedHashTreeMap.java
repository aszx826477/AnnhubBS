// 
// Decompiled by Procyon v0.5.30
// 

package com.google.gson.internal;

import java.util.Set;
import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.io.Serializable;
import java.util.AbstractMap;

public final class LinkedHashTreeMap extends AbstractMap implements Serializable
{
    private static final Comparator NATURAL_ORDER;
    Comparator comparator;
    private LinkedHashTreeMap$EntrySet entrySet;
    final LinkedHashTreeMap$Node header;
    private LinkedHashTreeMap$KeySet keySet;
    int modCount;
    int size;
    LinkedHashTreeMap$Node[] table;
    int threshold;
    
    static {
        NATURAL_ORDER = new LinkedHashTreeMap$1();
    }
    
    public LinkedHashTreeMap() {
        this(LinkedHashTreeMap.NATURAL_ORDER);
    }
    
    public LinkedHashTreeMap(final Comparator comparator) {
        this.size = 0;
        this.modCount = 0;
        Comparator natural_ORDER;
        if (comparator != null) {
            natural_ORDER = comparator;
        }
        else {
            natural_ORDER = LinkedHashTreeMap.NATURAL_ORDER;
        }
        this.comparator = natural_ORDER;
        this.header = new LinkedHashTreeMap$Node();
        this.table = new LinkedHashTreeMap$Node[16];
        final LinkedHashTreeMap$Node[] table = this.table;
        this.threshold = table.length / 2 + table.length / 4;
    }
    
    private void doubleCapacity() {
        this.table = doubleCapacity(this.table);
        final LinkedHashTreeMap$Node[] table = this.table;
        this.threshold = table.length / 2 + table.length / 4;
    }
    
    static LinkedHashTreeMap$Node[] doubleCapacity(final LinkedHashTreeMap$Node[] array) {
        final int length = array.length;
        final LinkedHashTreeMap$Node[] array2 = new LinkedHashTreeMap$Node[length * 2];
        final LinkedHashTreeMap$AvlIterator linkedHashTreeMap$AvlIterator = new LinkedHashTreeMap$AvlIterator();
        final LinkedHashTreeMap$AvlBuilder linkedHashTreeMap$AvlBuilder = new LinkedHashTreeMap$AvlBuilder();
        final LinkedHashTreeMap$AvlBuilder linkedHashTreeMap$AvlBuilder2 = new LinkedHashTreeMap$AvlBuilder();
        for (int i = 0; i < length; ++i) {
            final LinkedHashTreeMap$Node linkedHashTreeMap$Node = array[i];
            if (linkedHashTreeMap$Node != null) {
                linkedHashTreeMap$AvlIterator.reset(linkedHashTreeMap$Node);
                int n = 0;
                int n2 = 0;
                while (true) {
                    final LinkedHashTreeMap$Node next = linkedHashTreeMap$AvlIterator.next();
                    if (next == null) {
                        break;
                    }
                    if ((next.hash & length) == 0x0) {
                        ++n;
                    }
                    else {
                        ++n2;
                    }
                }
                linkedHashTreeMap$AvlBuilder.reset(n);
                linkedHashTreeMap$AvlBuilder2.reset(n2);
                linkedHashTreeMap$AvlIterator.reset(linkedHashTreeMap$Node);
                while (true) {
                    final LinkedHashTreeMap$Node next2 = linkedHashTreeMap$AvlIterator.next();
                    if (next2 == null) {
                        break;
                    }
                    if ((next2.hash & length) == 0x0) {
                        linkedHashTreeMap$AvlBuilder.add(next2);
                    }
                    else {
                        linkedHashTreeMap$AvlBuilder2.add(next2);
                    }
                }
                LinkedHashTreeMap$Node root = null;
                LinkedHashTreeMap$Node root2;
                if (n > 0) {
                    root2 = linkedHashTreeMap$AvlBuilder.root();
                }
                else {
                    root2 = null;
                }
                array2[i] = root2;
                final int n3 = i + length;
                if (n2 > 0) {
                    root = linkedHashTreeMap$AvlBuilder2.root();
                }
                array2[n3] = root;
            }
        }
        return array2;
    }
    
    private boolean equal(final Object o, final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    private void rebalance(final LinkedHashTreeMap$Node linkedHashTreeMap$Node, final boolean b) {
        for (LinkedHashTreeMap$Node parent = linkedHashTreeMap$Node; parent != null; parent = parent.parent) {
            final LinkedHashTreeMap$Node left = parent.left;
            final LinkedHashTreeMap$Node right = parent.right;
            int n = 0;
            int height;
            if (left != null) {
                height = left.height;
            }
            else {
                height = 0;
            }
            int height2;
            if (right != null) {
                height2 = right.height;
            }
            else {
                height2 = 0;
            }
            final int n2 = height - height2;
            if (n2 == -2) {
                final LinkedHashTreeMap$Node left2 = right.left;
                final LinkedHashTreeMap$Node right2 = right.right;
                int height3;
                if (right2 != null) {
                    height3 = right2.height;
                }
                else {
                    height3 = 0;
                }
                if (left2 != null) {
                    n = left2.height;
                }
                final int n3 = n - height3;
                if (n3 != -1 && (n3 != 0 || b)) {
                    this.rotateRight(right);
                    this.rotateLeft(parent);
                }
                else {
                    this.rotateLeft(parent);
                }
                if (b) {
                    break;
                }
            }
            else {
                final int n4 = 2;
                final int n5 = 1;
                if (n2 == n4) {
                    final LinkedHashTreeMap$Node left3 = left.left;
                    final LinkedHashTreeMap$Node right3 = left.right;
                    int height4;
                    if (right3 != null) {
                        height4 = right3.height;
                    }
                    else {
                        height4 = 0;
                    }
                    if (left3 != null) {
                        n = left3.height;
                    }
                    final int n6 = n - height4;
                    if (n6 != n5 && (n6 != 0 || b)) {
                        this.rotateLeft(left);
                        this.rotateRight(parent);
                    }
                    else {
                        this.rotateRight(parent);
                    }
                    if (b) {
                        break;
                    }
                }
                else if (n2 == 0) {
                    parent.height = height + 1;
                    if (b) {
                        break;
                    }
                }
                else {
                    parent.height = Math.max(height, height2) + n5;
                    if (!b) {
                        break;
                    }
                }
            }
        }
    }
    
    private void replaceInParent(final LinkedHashTreeMap$Node linkedHashTreeMap$Node, final LinkedHashTreeMap$Node linkedHashTreeMap$Node2) {
        final LinkedHashTreeMap$Node parent = linkedHashTreeMap$Node.parent;
        linkedHashTreeMap$Node.parent = null;
        if (linkedHashTreeMap$Node2 != null) {
            linkedHashTreeMap$Node2.parent = parent;
        }
        if (parent != null) {
            if (parent.left == linkedHashTreeMap$Node) {
                parent.left = linkedHashTreeMap$Node2;
            }
            else {
                parent.right = linkedHashTreeMap$Node2;
            }
        }
        else {
            final int hash = linkedHashTreeMap$Node.hash;
            final LinkedHashTreeMap$Node[] table = this.table;
            table[hash & table.length - 1] = linkedHashTreeMap$Node2;
        }
    }
    
    private void rotateLeft(final LinkedHashTreeMap$Node linkedHashTreeMap$Node) {
        final LinkedHashTreeMap$Node left = linkedHashTreeMap$Node.left;
        final LinkedHashTreeMap$Node right = linkedHashTreeMap$Node.right;
        final LinkedHashTreeMap$Node left2 = right.left;
        final LinkedHashTreeMap$Node right2 = right.right;
        linkedHashTreeMap$Node.right = left2;
        if (left2 != null) {
            left2.parent = linkedHashTreeMap$Node;
        }
        this.replaceInParent(linkedHashTreeMap$Node, right);
        right.left = linkedHashTreeMap$Node;
        linkedHashTreeMap$Node.parent = right;
        int height = 0;
        int height2;
        if (left != null) {
            height2 = left.height;
        }
        else {
            height2 = 0;
        }
        int height3;
        if (left2 != null) {
            height3 = left2.height;
        }
        else {
            height3 = 0;
        }
        linkedHashTreeMap$Node.height = Math.max(height2, height3) + 1;
        final int height4 = linkedHashTreeMap$Node.height;
        if (right2 != null) {
            height = right2.height;
        }
        right.height = Math.max(height4, height) + 1;
    }
    
    private void rotateRight(final LinkedHashTreeMap$Node linkedHashTreeMap$Node) {
        final LinkedHashTreeMap$Node left = linkedHashTreeMap$Node.left;
        final LinkedHashTreeMap$Node right = linkedHashTreeMap$Node.right;
        final LinkedHashTreeMap$Node left2 = left.left;
        final LinkedHashTreeMap$Node right2 = left.right;
        linkedHashTreeMap$Node.left = right2;
        if (right2 != null) {
            right2.parent = linkedHashTreeMap$Node;
        }
        this.replaceInParent(linkedHashTreeMap$Node, left);
        left.right = linkedHashTreeMap$Node;
        linkedHashTreeMap$Node.parent = left;
        int height = 0;
        int height2;
        if (right != null) {
            height2 = right.height;
        }
        else {
            height2 = 0;
        }
        int height3;
        if (right2 != null) {
            height3 = right2.height;
        }
        else {
            height3 = 0;
        }
        linkedHashTreeMap$Node.height = Math.max(height2, height3) + 1;
        final int height4 = linkedHashTreeMap$Node.height;
        if (left2 != null) {
            height = left2.height;
        }
        left.height = Math.max(height4, height) + 1;
    }
    
    private static int secondaryHash(int n) {
        n ^= (n >>> 20 ^ n >>> 12);
        return n >>> 7 ^ n ^ n >>> 4;
    }
    
    private Object writeReplace() {
        return new LinkedHashMap(this);
    }
    
    public void clear() {
        Arrays.fill(this.table, null);
        this.size = 0;
        ++this.modCount;
        final LinkedHashTreeMap$Node header = this.header;
        LinkedHashTreeMap$Node next2;
        for (LinkedHashTreeMap$Node next = header.next; next != header; next = next2) {
            next2 = next.next;
            next.prev = null;
            next.next = null;
        }
        header.prev = header;
        header.next = header;
    }
    
    public boolean containsKey(final Object o) {
        return this.findByObject(o) != null;
    }
    
    public Set entrySet() {
        final LinkedHashTreeMap$EntrySet entrySet = this.entrySet;
        LinkedHashTreeMap$EntrySet entrySet2;
        if (entrySet != null) {
            entrySet2 = entrySet;
        }
        else {
            entrySet2 = new LinkedHashTreeMap$EntrySet(this);
            this.entrySet = entrySet2;
        }
        return entrySet2;
    }
    
    LinkedHashTreeMap$Node find(final Object o, final boolean b) {
        final Comparator comparator = this.comparator;
        final LinkedHashTreeMap$Node[] table = this.table;
        final int secondaryHash = secondaryHash(o.hashCode());
        final int length = table.length;
        final int n = 1;
        final int n2 = secondaryHash & length - n;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node = table[n2];
        LinkedHashTreeMap$Node linkedHashTreeMap$Node3;
        int n5;
        if (linkedHashTreeMap$Node != null) {
            Comparable<Object> comparable;
            if (comparator == LinkedHashTreeMap.NATURAL_ORDER) {
                comparable = (Comparable<Object>)o;
            }
            else {
                comparable = null;
            }
            while (true) {
                int n3;
                if (comparable != null) {
                    n3 = comparable.compareTo(linkedHashTreeMap$Node.key);
                }
                else {
                    n3 = comparator.compare(o, linkedHashTreeMap$Node.key);
                }
                final int n4 = n3;
                if (n3 == 0) {
                    return linkedHashTreeMap$Node;
                }
                LinkedHashTreeMap$Node linkedHashTreeMap$Node2;
                if (n3 < 0) {
                    linkedHashTreeMap$Node2 = linkedHashTreeMap$Node.left;
                }
                else {
                    linkedHashTreeMap$Node2 = linkedHashTreeMap$Node.right;
                }
                if (linkedHashTreeMap$Node2 == null) {
                    linkedHashTreeMap$Node3 = linkedHashTreeMap$Node;
                    n5 = n4;
                    break;
                }
                linkedHashTreeMap$Node = linkedHashTreeMap$Node2;
            }
        }
        else {
            linkedHashTreeMap$Node3 = linkedHashTreeMap$Node;
            n5 = 0;
        }
        if (!b) {
            return null;
        }
        final LinkedHashTreeMap$Node header = this.header;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node5;
        if (linkedHashTreeMap$Node3 == null) {
            if (comparator == LinkedHashTreeMap.NATURAL_ORDER && !(o instanceof Comparable)) {
                final StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(" is not Comparable");
                throw new ClassCastException(sb.toString());
            }
            final LinkedHashTreeMap$Node prev;
            final LinkedHashTreeMap$Node linkedHashTreeMap$Node4 = new LinkedHashTreeMap$Node(linkedHashTreeMap$Node3, o, secondaryHash, header, prev);
            prev = header.prev;
            linkedHashTreeMap$Node5 = linkedHashTreeMap$Node4;
            table[n2] = linkedHashTreeMap$Node4;
        }
        else {
            final LinkedHashTreeMap$Node prev2;
            final LinkedHashTreeMap$Node linkedHashTreeMap$Node6 = new LinkedHashTreeMap$Node(linkedHashTreeMap$Node3, o, secondaryHash, header, prev2);
            prev2 = header.prev;
            linkedHashTreeMap$Node5 = linkedHashTreeMap$Node6;
            if (n5 < 0) {
                linkedHashTreeMap$Node3.left = linkedHashTreeMap$Node6;
            }
            else {
                linkedHashTreeMap$Node3.right = linkedHashTreeMap$Node6;
            }
            this.rebalance(linkedHashTreeMap$Node3, n != 0);
        }
        if (this.size++ > this.threshold) {
            this.doubleCapacity();
        }
        this.modCount += n;
        return linkedHashTreeMap$Node5;
    }
    
    LinkedHashTreeMap$Node findByEntry(final Entry entry) {
        final LinkedHashTreeMap$Node byObject = this.findByObject(entry.getKey());
        LinkedHashTreeMap$Node linkedHashTreeMap$Node;
        if (byObject != null && this.equal(byObject.value, entry.getValue())) {
            linkedHashTreeMap$Node = byObject;
        }
        else {
            linkedHashTreeMap$Node = null;
        }
        return linkedHashTreeMap$Node;
    }
    
    LinkedHashTreeMap$Node findByObject(final Object o) {
        LinkedHashTreeMap$Node find = null;
        if (o != null) {
            try {
                find = this.find(o, false);
            }
            catch (ClassCastException ex) {
                return null;
            }
        }
        return find;
    }
    
    public Object get(final Object o) {
        final LinkedHashTreeMap$Node byObject = this.findByObject(o);
        Object value;
        if (byObject != null) {
            value = byObject.value;
        }
        else {
            value = null;
        }
        return value;
    }
    
    public Set keySet() {
        final LinkedHashTreeMap$KeySet keySet = this.keySet;
        LinkedHashTreeMap$KeySet keySet2;
        if (keySet != null) {
            keySet2 = keySet;
        }
        else {
            keySet2 = new LinkedHashTreeMap$KeySet(this);
            this.keySet = keySet2;
        }
        return keySet2;
    }
    
    public Object put(final Object o, final Object value) {
        if (o != null) {
            final LinkedHashTreeMap$Node find = this.find(o, true);
            final Object value2 = find.value;
            find.value = value;
            return value2;
        }
        throw new NullPointerException("key == null");
    }
    
    public Object remove(final Object o) {
        final LinkedHashTreeMap$Node removeInternalByKey = this.removeInternalByKey(o);
        Object value;
        if (removeInternalByKey != null) {
            value = removeInternalByKey.value;
        }
        else {
            value = null;
        }
        return value;
    }
    
    void removeInternal(final LinkedHashTreeMap$Node linkedHashTreeMap$Node, final boolean b) {
        if (b) {
            linkedHashTreeMap$Node.prev.next = linkedHashTreeMap$Node.next;
            linkedHashTreeMap$Node.next.prev = linkedHashTreeMap$Node.prev;
            linkedHashTreeMap$Node.prev = null;
            linkedHashTreeMap$Node.next = null;
        }
        final LinkedHashTreeMap$Node left = linkedHashTreeMap$Node.left;
        final LinkedHashTreeMap$Node right = linkedHashTreeMap$Node.right;
        final LinkedHashTreeMap$Node parent = linkedHashTreeMap$Node.parent;
        if (left != null && right != null) {
            LinkedHashTreeMap$Node linkedHashTreeMap$Node2;
            if (left.height > right.height) {
                linkedHashTreeMap$Node2 = left.last();
            }
            else {
                linkedHashTreeMap$Node2 = right.first();
            }
            this.removeInternal(linkedHashTreeMap$Node2, false);
            int height = 0;
            final LinkedHashTreeMap$Node left2 = linkedHashTreeMap$Node.left;
            if (left2 != null) {
                height = left2.height;
                linkedHashTreeMap$Node2.left = left2;
                left2.parent = linkedHashTreeMap$Node2;
                linkedHashTreeMap$Node.left = null;
            }
            int height2 = 0;
            final LinkedHashTreeMap$Node right2 = linkedHashTreeMap$Node.right;
            if (right2 != null) {
                height2 = right2.height;
                linkedHashTreeMap$Node2.right = right2;
                right2.parent = linkedHashTreeMap$Node2;
                linkedHashTreeMap$Node.right = null;
            }
            linkedHashTreeMap$Node2.height = Math.max(height, height2) + 1;
            this.replaceInParent(linkedHashTreeMap$Node, linkedHashTreeMap$Node2);
            return;
        }
        if (left != null) {
            this.replaceInParent(linkedHashTreeMap$Node, left);
            linkedHashTreeMap$Node.left = null;
        }
        else if (right != null) {
            this.replaceInParent(linkedHashTreeMap$Node, right);
            linkedHashTreeMap$Node.right = null;
        }
        else {
            this.replaceInParent(linkedHashTreeMap$Node, null);
        }
        this.rebalance(parent, false);
        --this.size;
        ++this.modCount;
    }
    
    LinkedHashTreeMap$Node removeInternalByKey(final Object o) {
        final LinkedHashTreeMap$Node byObject = this.findByObject(o);
        if (byObject != null) {
            this.removeInternal(byObject, true);
        }
        return byObject;
    }
    
    public int size() {
        return this.size;
    }
}
