import jieba
from src.main import process

def stopwordslist(filepath):
    stopwords = [line.strip() for line in open(filepath, 'r', encoding='utf-8').readlines()]
    return stopwords

def getLabels(corpora):
    print(corpora)
    t_list = jieba.cut(corpora)
    t_list = ",".join(t_list)
    t_list = t_list.split(',')
    f_list = []
    for j in t_list:
        if (u'\u0041'  <=  j<=u'\u005a')  or  (u'\u0061'  <=  j<=u'\u007a'):
            if len(j) == 1:
                continue
        if j not in stopwordslist('./stopwords.txt'):
            f_list.append(j)
    corpora = " ".join(f_list)
    print(corpora)
    corpora = process(corpora)
    print(corpora)
    return " ".join(corpora)

# getLabels('下图 我国 地区 农业 生产 模式图 读图 完成 下列 各题 农业 生产 类型 粮草 结合 混合农业 人工 草地 畜牧业 多元 开发 立体 农业 温带 草原 畜牧业 生产 模式 社会 经济 影响 下列 说法 可信 减轻 天然 草场 压力 保持 土壤肥力 增加 大量 就业机会 增加 农民 收入')