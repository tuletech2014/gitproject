import yaml
content = """
python: all
  while: 
   - 16
   - jk
"""
data = yaml.load(content)
print data